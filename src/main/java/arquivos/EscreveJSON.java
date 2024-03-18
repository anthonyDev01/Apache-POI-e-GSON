package arquivos;

import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreveJSON {
    public static void main(String[] args) throws IOException {
        Usuario usuario1 = new Usuario();
        usuario1.setCpf("389632072-42");
        usuario1.setLogin("anthony01");
        usuario1.setNome("anthony ndubisi");
        usuario1.setSenha("123456");

        Usuario usuario2 = new Usuario();
        usuario2.setCpf("1826378041-61");
        usuario2.setLogin("senza");
        usuario2.setNome("Leopoldino Cruz");
        usuario2.setSenha("123456");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUser = gson.toJson(usuarios);

        FileWriter fileWriter = new FileWriter("D:\\Documentos\\projetos\\Apache-POI-e-GSON\\src\\main\\java\\arquivos\\filejson.json");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();

        /*----------------------------------------Lendo o arquivo JSON----------------------------------------*/

        FileReader fileReader = new FileReader("D:\\Documentos\\projetos\\Apache-POI-e-GSON\\src\\main\\java\\arquivos\\filejson.json");

       JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

       List<Usuario> listUsuario = new ArrayList<Usuario>();

       for(JsonElement jsonElement : jsonArray){
           Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
           listUsuario.add(usuario);
       }

       System.out.println("Leitura do arquivo JSON: " + listUsuario);
    }
}
