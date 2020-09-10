import java.util.*;

public class Codec {
    Long id = 0L;
    Map<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(String.valueOf(id), longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String id = shortUrl.substring(19);
        return map.get(id);
    }
}