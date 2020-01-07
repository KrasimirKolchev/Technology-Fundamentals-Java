package N_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemons = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;

        while (pokemons.size() > 0) {

            int pokemonIndex = Integer.parseInt(scanner.nextLine());
            int pokemonDistance;

            if (pokemonIndex >= 0 && pokemonIndex < pokemons.size()) {
                pokemonDistance = pokemons.get(pokemonIndex);
                sum += pokemonDistance;
                pokemons.remove(pokemonIndex);
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= pokemonDistance) {
                        pokemons.set(i, (pokemons.get(i) + pokemonDistance));
                    } else {
                        pokemons.set(i, (pokemons.get(i) - pokemonDistance));
                    }
                }
            } else if (pokemonIndex < 0) {
                pokemonDistance = pokemons.get(0);
                sum += pokemonDistance;
                pokemons.remove(0);
                pokemons.add(0, pokemons.get(pokemons.size() - 1));
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= pokemonDistance) {
                        pokemons.set(i, (pokemons.get(i) + pokemonDistance));
                    } else {
                        pokemons.set(i, (pokemons.get(i) - pokemonDistance));
                    }
                }
            } else if (pokemonIndex >= pokemons.size()) {
                pokemonDistance = pokemons.get(pokemons.size() - 1);
                sum += pokemonDistance;
                pokemons.remove(pokemons.size() - 1);
                pokemons.add(pokemons.get(0));
                for (int i = 0; i < pokemons.size(); i++) {
                    if (pokemons.get(i) <= pokemonDistance) {
                        pokemons.set(i, (pokemons.get(i) + pokemonDistance));
                    } else {
                        pokemons.set(i, (pokemons.get(i) - pokemonDistance));
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
