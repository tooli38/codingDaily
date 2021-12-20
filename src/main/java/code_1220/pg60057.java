package code_1220;


import java.util.stream.Stream;

public class pg60057 {
    public static void main(String args[]) {
        String s = "a";
        Integer ans = solution(s);
        System.out.println(ans);
    }

    private static int solution(String s) {
        return Stream.iterate(1, i -> i + 1)
                        .mapToInt(a -> findLength(s, a))
                        .parallel()
                        .limit(s.length()/2 + 1)
                        .min().getAsInt();
    }

    private static Integer findLength(String s, Integer size) {
        Integer ans = 0;

        if(size >= s.length()) return s.length();

        StringBuffer sb = new StringBuffer();
        int cont = 1;
        String prev = s.substring(0, size);
        for(int i = size; i < s.length(); i+=size){
            String con = "";
            //마지막 구역에서 나누어 떨어지지 않을 경우 Outbound에러를 방지하기 위해 추가함.
            if(i + size <= s.length())
                con = s.substring(i, i + size);
            else
                con = s.substring(i, s.length());

            //만약에 이전과 같으면 압축이 가능하다.
            if(prev.equals(con)){
                cont++;
                continue;
            } else {
                //2개 이상 압축이 가능하면 새롭게 붙여준다.
                if(cont > 1) {
                    sb.append(cont).append(prev);
                } else {
                    sb.append(prev);
                }
                cont = 1;
            }
            prev = con;

        }
        if(cont > 1) {
            sb.append(cont).append(prev);
        } else {
            sb.append(prev);
        }

        return sb.length();
    }
}
