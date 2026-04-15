import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Portal p = new Portal();

        Recruiter r = new Recruiter(1,"Arun","a@a.com","TechCorp");
        JobSeeker s = new JobSeeker(2,"Raja","r@r.com");

        p.add(new FullTimeJob(1,"Dev","Chennai",50000,"Java",r));
        p.add(new PartTimeJob(2,"Tester","Chennai",20000,"QA",r));

        p.view();
        System.out.print("Enter Job ID to apply: ");
        int jobId = sc.nextInt();
        p.apply(s, jobId);
        System.out.println("Applied successfully for Job ID: " + jobId);
    }
}

abstract class User {
    int id; String name, email;
    User(int id, String n, String e){ this.id=id; name=n; email=e; }
}

class Recruiter extends User {
    String company;
    Recruiter(int i,String n,String e,String c){ super(i,n,e); company=c; }
}

class JobSeeker extends User {
    JobSeeker(int i,String n,String e){ super(i,n,e); }
}

abstract class Job {
    int id; String title, loc, skill; double sal; Recruiter r;
    Job(int i,String t,String l,double s,String sk,Recruiter r){
        id=i; title=t; loc=l; sal=s; skill=sk; this.r=r;
    }
    abstract String type();
    void show(){
        System.out.println(id+" "+type()+" "+title+" "+r.company);
    }
}

class FullTimeJob extends Job {
    FullTimeJob(int i,String t,String l,double s,String sk,Recruiter r){
        super(i,t,l,s,sk,r);
    }
    String type(){ return "Full"; }
}

class PartTimeJob extends Job {
    PartTimeJob(int i,String t,String l,double s,String sk,Recruiter r){
        super(i,t,l,s,sk,r);
    }
    String type(){ return "Part"; }
}

class Application {
    JobSeeker s; Job j;
    Application(JobSeeker s,Job j){ this.s=s; this.j=j; }
}

class Portal {
    List<Job> jobs = new ArrayList<>();
    List<Application> apps = new ArrayList<>();

    void add(Job j){ jobs.add(j); }

    void view(){
        for(Job j:jobs) j.show();
    }

    void apply(JobSeeker s,int id){
        for(Job j:jobs)
            if(j.id==id) apps.add(new Application(s,j));
    }
}