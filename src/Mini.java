import java.util.*;
public class Mini {
    public static void main(String[] args){
        Map<String,List<String>>coupleLikes=new HashMap<>();
        coupleLikes.put("Aiza",Arrays.asList("Chai","Mango ","Pasta ","Biryani"));
        coupleLikes.put("Danish",Arrays.asList("Chai","Pasta","Pulao"));
        Map<String,List<String>>coupleDislike=new HashMap<>();
        coupleDislike.put("Aiza",Arrays.asList("Coffee","Pulao","Milk"));
        coupleDislike.put("Danish", Arrays.asList("Milk","Biryani","Turnip"));
        for(String couple:coupleLikes.keySet()){
            System.out.println(couple + " likes ");
            for(String like:coupleLikes.get(couple)){
                System .out.println("-" + like);
            }
        }

        for(String couples:coupleDislike.keySet()){
            System.out.println(couples +" dislikes");
            for(String dislike:coupleDislike.get(couples)){
                System.out.println(" - " +dislike);
            }
        }
        Set<String>similarLikes=new HashSet<>(coupleLikes.get("Aiza"));
                similarLikes.retainAll(coupleLikes.get("Danish"));
        Set<String>similarDislikes=new HashSet<>(coupleDislike.get("Aiza"));
        similarDislikes.retainAll(coupleDislike.get("Danish"));
        System.out.println("\n ---------Similar Likes-------");
        for(String person :similarLikes){
            System.out.println(" - " +person);
        }
        System.out.println("\n ------Similar dislikes ------------");
        for(String item:similarDislikes){
            System.out.println(" -" + item );
        }
    }
}
