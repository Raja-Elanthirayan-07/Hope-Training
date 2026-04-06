import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

abstract class User {
    private int userId;
    private String name;
    private String email;

    public User(int userId, String name, String email) {
        if (userId <= 0) {
            throw new ValidationException("User ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Name cannot be empty.");
        }
        if (email == null || !email.contains("@")) {
            throw new ValidationException("Invalid email.");
        }
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Recruiter extends User {
    private String companyName;

    public Recruiter(int userId, String name, String email, String companyName) {
        super(userId, name, email);
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new ValidationException("Company name cannot be empty.");
        }
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}

class JobSeeker extends User {
    private String resumeSummary;

    public JobSeeker(int userId, String name, String email, String resumeSummary) {
        super(userId, name, email);
        if (resumeSummary == null || resumeSummary.trim().isEmpty()) {
            throw new ValidationException("Resume summary cannot be empty.");
        }
        this.resumeSummary = resumeSummary;
    }

    public String getResumeSummary() {
        return resumeSummary;
    }
}

abstract class Job {
    private int jobId;
    private String title;
    private String location;
    private double salary;
    private String requiredSkill;
    private Recruiter recruiter;

    public Job(int jobId, String title, String location, double salary, String requiredSkill, Recruiter recruiter) {
        if (jobId <= 0) {
            throw new ValidationException("Job ID must be positive.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new ValidationException("Job title cannot be empty.");
        }
        if (location == null || location.trim().isEmpty()) {
            throw new ValidationException("Location cannot be empty.");
        }
        if (salary <= 0) {
            throw new ValidationException("Salary must be greater than 0.");
        }
        if (requiredSkill == null || requiredSkill.trim().isEmpty()) {
            throw new ValidationException("Required skill cannot be empty.");
        }
        if (recruiter == null) {
            throw new ValidationException("Recruiter cannot be null.");
        }

        this.jobId = jobId;
        this.title = title;
        this.location = location;
        this.salary = salary;
        this.requiredSkill = requiredSkill;
        this.recruiter = recruiter;
    }

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }

    public String getRequiredSkill() {
        return requiredSkill;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public abstract String getJobType();

    public void displayJob() {
        System.out.println("Job ID: " + jobId);
        System.out.println("Type: " + getJobType());
        System.out.println("Title: " + title);
        System.out.println("Company: " + recruiter.getCompanyName());
        System.out.println("Location: " + location);
        System.out.println("Salary: " + salary);
        System.out.println("Skill Required: " + requiredSkill);
        System.out.println("----------------------------");
    }
}

class FullTimeJob extends Job {
    public FullTimeJob(int jobId, String title, String location, double salary, String requiredSkill, Recruiter recruiter) {
        super(jobId, title, location, salary, requiredSkill, recruiter);
    }

    @Override
    public String getJobType() {
        return "Full-Time";
    }
}

class PartTimeJob extends Job {
    public PartTimeJob(int jobId, String title, String location, double salary, String requiredSkill, Recruiter recruiter) {
        super(jobId, title, location, salary, requiredSkill, recruiter);
    }

    @Override
    public String getJobType() {
        return "Part-Time";
    }
}

class Application {
    private int applicationId;
    private JobSeeker applicant;
    private Job job;
    private String status;

    public Application(int applicationId, JobSeeker applicant, Job job) {
        this.applicationId = applicationId;
        this.applicant = applicant;
        this.job = job;
        this.status = "Applied";
    }

    public int getApplicationId() {
        return applicationId;
    }

    public JobSeeker getApplicant() {
        return applicant;
    }

    public Job getJob() {
        return job;
    }

    public String getStatus() {
        return status;
    }
}

class JobPortal {
    private List<Job> jobs = new ArrayList<>();
    private List<Application> applications = new ArrayList<>();
    private int nextApplicationId = 1;

    public void addJob(Job job) {
        for (Job j : jobs) {
            if (j.getJobId() == job.getJobId()) {
                throw new ValidationException("Job ID already exists.");
            }
        }
        jobs.add(job);
        System.out.println("Job added successfully.");
    }

    public void viewJobs() {
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
            return;
        }
        for (Job job : jobs) {
            job.displayJob();
        }
    }

    public Job findJobById(int jobId) {
        for (Job job : jobs) {
            if (job.getJobId() == jobId) {
                return job;
            }
        }
        return null;
    }

    public void applyForJob(JobSeeker seeker, int jobId) {
        Job job = findJobById(jobId);

        if (job == null) {
            throw new ValidationException("Job not found.");
        }

        for (Application app : applications) {
            if (app.getApplicant().getUserId() == seeker.getUserId() &&
                app.getJob().getJobId() == jobId) {
                throw new ValidationException("You have already applied for this job.");
            }
        }

        applications.add(new Application(nextApplicationId++, seeker, job));
        System.out.println("Application submitted successfully.");
    }

    public void viewApplications() {
        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (Application app : applications) {
            System.out.println("Application ID: " + app.getApplicationId());
            System.out.println("Applicant: " + app.getApplicant().getName());
            System.out.println("Job: " + app.getJob().getTitle());
            System.out.println("Company: " + app.getJob().getRecruiter().getCompanyName());
            System.out.println("Status: " + app.getStatus());
            System.out.println("----------------------------");
        }
    }

    public void searchJobs(String keyword) {
        boolean found = false;

        for (Job job : jobs) {
            if (job.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                job.getRequiredSkill().toLowerCase().contains(keyword.toLowerCase()) ||
                job.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
                job.displayJob();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching jobs found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JobPortal portal = new JobPortal();

        try {
            Recruiter recruiter = new Recruiter(1, "Arun", "arun@abc.com", "TechCorp");
            JobSeeker seeker = new JobSeeker(101, "Raja", "raja@gmail.com", "Interested in Java and Web Development");

            while (true) {
                System.out.println("\n===== JOB PORTAL SYSTEM =====");
                System.out.println("1. Add Full-Time Job");
                System.out.println("2. Add Part-Time Job");
                System.out.println("3. View Jobs");
                System.out.println("4. Search Jobs");
                System.out.println("5. Apply for Job");
                System.out.println("6. View Applications");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: {
                        System.out.print("Job ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Location: ");
                        String location = sc.nextLine();

                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Required Skill: ");
                        String skill = sc.nextLine();

                        portal.addJob(new FullTimeJob(id, title, location, salary, skill, recruiter));
                        break;
                    }

                    case 2: {
                        System.out.print("Job ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Location: ");
                        String location = sc.nextLine();

                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Required Skill: ");
                        String skill = sc.nextLine();

                        portal.addJob(new PartTimeJob(id, title, location, salary, skill, recruiter));
                        break;
                    }

                    case 3:
                        portal.viewJobs();
                        break;

                    case 4:
                        System.out.print("Enter keyword to search: ");
                        String keyword = sc.nextLine();
                        portal.searchJobs(keyword);
                        break;

                    case 5:
                        System.out.print("Enter Job ID to apply: ");
                        int jobId = sc.nextInt();
                        sc.nextLine();
                        portal.applyForJob(seeker, jobId);
                        break;

                    case 6:
                        portal.viewApplications();
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (ValidationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}