public class sixDigitLowerAlphaKeyGenerationStrategy implements KeyGenerationStrategy{
    private long cnt;

    public sixDigitLowerAlphaKeyGenerationStrategy() {
        this.cnt = 26*26*26*26*26 + 26*26*26*26 + 26*26*26 + 26*26+ 26 +1;
    }

    @Override
    public String getKey() {
        long val = cnt;
        String key="";
        while(val>0){
            long mod = val%26;
            val = val/26;
            if(mod>0){
                long a = 'A'-1+mod;
                char ch = (char)a;
                key += ch;
            }else{
                key+='Z';
                val--;
            }
        }
        cnt++;
        System.out.println(key);
        return key;
    }
}
