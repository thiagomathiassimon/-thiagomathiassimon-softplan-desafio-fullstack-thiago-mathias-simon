package Util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.sql.Date; import java.text.SimpleDateFormat;


public class JWTUtil {   
	
    private static String key = "SECRET_TOKEN" + getPegaDataAtual();

    public static final String TOKEN_HEADER = "Authorization";

    public static String create(String subject) {

        return Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    public static Jws<Claims> decode(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }

    public static String getPegaDataAtual() { 
    	Date data = new Date(System.currentTimeMillis()); 
    	SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 
    	System.out.println(formatarDate.format(data));
    	return formatarDate.format(data); 
    }
    
    
}
