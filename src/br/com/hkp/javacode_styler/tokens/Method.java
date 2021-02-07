package br.com.hkp.javacode_styler.tokens;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author userhugo
 */
public final class Method extends Tokens
{
    /*[01]---------------------------------------------------------------------
    
    -------------------------------------------------------------------------*/
    /**
     *
     */
    @Override
    public void map() 
    {
               
        HashSet<String> set = new HashSet<>(HASH_CAPACITY); 
        
        Matcher match = Pattern.compile("(\\b[_a-z$][\\w$]*)(\\s|\\n)*([(])").
                        matcher(javaSourceCode);
                          
        while (match.find()) set.add(match.group(1)); 
                    
        set.forEach
        (
            element ->
            {
                String mark = getMark();

                javaSourceCode =
                        javaSourceCode.replaceAll("\\b" + element + "\\b", mark);

                MAP.put(mark, TAG + "method\">" + element + "</span>");
            }
        ); //for
        
    }//map()
    
    
}//classe Method
