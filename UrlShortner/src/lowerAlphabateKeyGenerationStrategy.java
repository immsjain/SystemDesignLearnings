public class lowerAlphabateKeyGenerationStrategy  implements KeyGenerationStrategy{
    private int cnt;

    public lowerAlphabateKeyGenerationStrategy() {
            cnt=1;
    }

    @Override
    public String getKey() {
        int val = cnt;
        String key="";
        while(val>0){
            int mod = val%26;
            val = val/26;
            if(mod>0){
                int a = 'A'-1+mod;
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
