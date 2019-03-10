package com.softeam.presentation.kubernetes.microprofile;

import com.softeam.presentation.kubernetes.microprofile.model.enums.Devise;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;


@Ignore
public class DataGeneratorTest {

    private static String INSERT = "INSERT INTO PORTFOLIO (CODE,AMOUNT,DEVISE,MANAGER) VALUES ('%s',%d,'%s','%s');";


    @Test
    public void shouldGenerateData() {
        Function<Integer, String> pfCompute = row -> "PTF" + String.format("%07d", row);
        String[] manager = new String[]{"Achref", "Antoine", "Baptiste"};

        Devise[] devises = Devise.values();


        IntStream.range(4000,5000).mapToObj(row -> {
            int amount = (int) ((1 + Math.random()) * 5000);
            String aManager = manager[new Random().nextInt(manager.length)];
            Devise aDevise = devises[new Random().nextInt(devises.length)];
            String code = "PTF" + String.format("%07d", row);
            return String.format(INSERT, code, amount, aDevise, aManager);
        }).forEach(line -> {
            System.out.println(line);
        });
    }
}
