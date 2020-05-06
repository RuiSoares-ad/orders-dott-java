package pt.dott.backend.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CustomerName {

    private final static int NUM_COSTUMERS = 200;

    private static final List<String> names = Arrays.asList("Ana", "Andreia", "Adriana", "Adriano", "André", "Ângela",
            "Adélia", "Amilcar", "Adolfo", "Alexandre", "Amadeu", "Anabela", "Aurea", "Américo", "Aníbal", "Angélica", "Armando",
            "Arménio", "Alberto", "Bruna", "Bruno", "Bernardo", "Bianca", "Beatriz", "Benedita", "Bartolomeu", "Benjamim", "Bernardete",
            "Brigite", "Brigida", "Carla", "Cátia", "Carlos", "Cândido", "Carmen", "Catarina", "Cândida", "Cristiano", "Cláudio",
            "Cláudia", "Cristiana", "Carina", "Carlota", "Cipriano", "Celestiano", "Carminda", "Carolina", "Custódio", "Diogo", "Diana",
            "Daniela", "Dário", "Daniel", "Davide", "Diamantino", "Dalila", "Dália", "Diamantina", "Deolinda", "Dânia", "Débora",
            "Eva", "Ermelinda", "Esmeralda", "Éder", "Edgar", "Edmundo", "Eduardo", "Eusébio", "Elídio", "Elisa",
            "Elisabete", "Ema", "Filipa", "Fátima", "Francisca", "Fábio", "Filipe", "Francisco", "Frederico", "Frederica", "Felisberto",
            "Felisberta", "Fabrício", "Fausto", "Filomena", "Flávio", "Flávia", "Florinda", "Flora", "Fernanda", "Fernando", "Guilherme",
            "Gustavo", "Gonçalo", "Guilhermina", "Gisele", "Graça", "Gisela", "Gabriela", "Gilmar", "Guiomar", "Helena",
            "Helder", "Hélio", "Hugo", "Henrique", "Ivo", "Iva", "Inês", "Ilídio", "Isidro", "Ismael",
            "Isabel", "Ivan", "Iara", "Ilda", "Índia", "Íris", "Joana", "João", "Juliana", "Judite", "José",
            "Josefina", "Jorge", "Joaquim", "Joaquina", "Jaime", "Joel", "Jacinta", "Jade", "Josué", "Jacinto", "Júlio",
            "Justino", "Júnior", "Jessica", "Jennifer", "Júlia", "Luís", "Luísa", "Leonor", "Leandro", "Leonardo",
            "Lourenço", "Liliana", "Leonel", "Lia", "Lúcio", "Lúcia", "Laura", "Lorena", "Lara", "Laurentino",
            "Laurentina", "Mateus", "Manuel", "Margarida", "Maria", "Marcos", "Marta", "Marco", "Marcelino", "Madalena", "Martim",
            "Mia", "Maurício", "Moisés", "Magda", "Mafalda", "Melanie", "Nuno", "Nelson", "Micaela", "Nádia",
            "Natália", "Mara", "Natasha", "Oscar", "Olívia", "Olinda", "Otávio", "Odete", "Olga", "Paulo", "Pedro",
            "Paula", "Palmira", "Paulina", "Patrícia", "Quintino", "Rui", "Ricardo", "Roberto", "Rodrigo", "Romeu", "Roberta",
            "Rafael", "Rafaela", "Rogério", "Ruben", "Raquel", "Rebeca", "Regina", "Renata", "Renato", "Rita",
            "Rosário", "Rosa", "Rosália", "Rosalina", "Silvia", "Silvana", "Sara", "Silvino", "Sérgio", "Sabrina", "Sandra",
            "Sónia", "Sofia", "Simone", "Simara", "Soraia", "Simão", "Sílvio", "Silvério", "Tânia", "Tamara", "Tobias",
            "Tomás", "Tiago", "Tadeu", "Telmo", "Teodoro", "Tomé", "Tatiana", "Teresa", "Telma", "Tiffany",
            "Ulisses", "Ulmira", "Valentina", "Valentim", "Vitória", "Vasco", "Vítor", "Valdemar", "Valéria", "Vera", "Verónica",
            "Virgínia", "Violeta", "Viviana", "Vicente", "Vitorino", "Virgílio", "Xavier", "Zulmira", "Vânia");

    public static List<String> getRandomNamesList() {
        List<String> namesList = new ArrayList<>();

        for(int i = 0; i != NUM_COSTUMERS; i++){
            namesList.add(names.get(new Random().nextInt(names.size()-1)));
        }

        return names;
    }

}
