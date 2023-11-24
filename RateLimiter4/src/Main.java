// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        User user1 = new User(1,"Shubham");
        User user2 = new User(2,"Vaishali");
        User user3 = new User(3,"Shivani");

        Request request1 = user1.createRequest(1,new Data("Hii"),1);
        Request request2 = user1.createRequest(2,new Data("Hii"),1);
        Request request3 = user1.createRequest(3,new Data("Hii"),1);
        Request request4 = user2.createRequest(4,new Data("Hii"),1);
        Request request5 = user1.createRequest(5,new Data("Hii"),1);
        Request request6 = user2.createRequest(6,new Data("Hii"),1);
        Request request7 = user2.createRequest(7,new Data("Hii"),1);

        RateLimiter rateLimiter = RateLimiter.getInstance(2,1);
        if(rateLimiter.validate(request1)){
            request1.process();
        }else{
            request1.fail();
        }

        if(rateLimiter.validate(request2)){
            request2.process();
        }else{
            request2.fail();
        }

        if(rateLimiter.validate(request3)){
            request3.process();
        }else{
            request3.fail();
        }

        if(rateLimiter.validate(request4)){
            request4.process();
        }else{
            request4.fail();
        }

        if(rateLimiter.validate(request5)){
            request5.process();
        }else{
            request5.fail();
        }

        if(rateLimiter.validate(request6)){
            request6.process();
        }else{
            request6.fail();
        }

        if(rateLimiter.validate(request7)){
            request7.process();
        }else{
            request7.fail();
        }

    }
}