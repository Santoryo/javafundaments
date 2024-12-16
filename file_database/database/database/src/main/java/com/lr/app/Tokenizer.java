package com.lr.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer
{
    private List<String> tokens;
    private int index;

    public Tokenizer(String input)
    {
        String regex = "(\\w+|!=|>=|<=|<>|=|>|<|\\*|['\"].*?['\"]|[,();])";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        tokens = new ArrayList<>();

        while (matcher.find())
        {
            String token = matcher.group(0);
            if ((token.startsWith("\"") && token.endsWith("\"")) || (token.startsWith("'") && token.endsWith("'")))
            {
                token = token.substring(1, token.length() - 1);
            }
            tokens.add(token);
        }

        this.index = 0;
    }

    public String nextToken()
    {
        if (index < tokens.size())
        {
            return tokens.get(index++);
        }
        return null;
    }

    public ArrayList<String> getTokens()
    {
        return new ArrayList<>(tokens);
    }

    public boolean hasNextToken()
    {
        return index < tokens.size();
    }

    public String peekNext()
    {
        String token = null;
        if (index < tokens.size())
        {
            token = tokens.get(index++);
            index--;
            return token;
        }
        return null;
    }
}
