// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User user1 = new User(1,"Shubham");
        User user2 = new User(1,"Vaibhav");

        RateLimiter rateLimiter = RateLimiter.getInstance(20,60);

        URequest uRequest1  = user1.createReq(1,"Hi",1);
        URequest uRequest2  = user1.createReq(2,"Hi",1);
        URequest uRequest3  = user1.createReq(3,"Hi",1);
        URequest uRequest4 =  user1.createReq(4,"Hi",2);
        URequest uRequest5  = user1.createReq(5,"Hi",7);
        URequest uRequest6  = user1.createReq(6,"Hi",7);
        URequest uRequest7  = user1.createReq(7,"Hi",61);
        URequest uRequest8  = user1.createReq(8,"Hi",62);

        if(rateLimiter.validate(uRequest1)){
            System.out.println("Valid");
        }else{
            System.out.println("not Valid");
        }

        if(rateLimiter.validate(uRequest2)){
            System.out.println("Valid");
        }else{
            System.out.println("not Valid");
        }

        if(rateLimiter.validate(uRequest3)){
            System.out.println("Valid");
        }else{
            System.out.println("not Valid");
        }

        if(rateLimiter.validate(uRequest4)){
            System.out.println("Valid");
        }else{
            System.out.println("not Valid");
        }

        if(rateLimiter.validate(uRequest5)){
            System.out.println("Valid");
        }else{
            System.out.println("not Valid");
        }

        if(rateLimiter.validate(uRequest6)){
            System.out.println("Valid");
        }else{
            System.out.println("not Valid");
        }

        if(rateLimiter.validate(uRequest7)){
            System.out.println("Valid");
        }else{
            System.out.println("not Valid");
        }

        if(rateLimiter.validate(uRequest8)){
            System.out.println("Valid");
        }else{
            System.out.println("not Valid");
        }





    }
}