package com.fgr.pokemon.service;

import com.fgr.pokemon.request.RenameRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AppServiceImpl implements AppService{
    @Override
    public Boolean catchWith50PercentProbability() {
        Random random = new Random();
        int chance = random.nextInt(100);
        return chance < 50;
    }

    @Override
    public Integer releasePokemon() {
        Random random = new Random();
        int number = random.nextInt(100);

        if (isPrime(number)) {
            return number;
        } else {
            return -1;
        }
    }

    @Override
    public String renamePokemon(RenameRequest req) {
        String[] splitName = req.getName().split("-");
        return splitName[0]+"-"+getFibonacciNumber(req.getCount()).toString();
    }

    private Boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    private Integer getFibonacciNumber(int index) {
        if (index <= 0) {
            return 0;
        } else if (index == 1) {
            return 1;
        } else {
            int fib1 = 0;
            int fib2 = 1;
            int nextFib = 0;

            for (int i = 2; i <= index; i++) {
                nextFib = fib1 + fib2;
                fib1 = fib2;
                fib2 = nextFib;
            }

            return nextFib;
        }
    }
}
