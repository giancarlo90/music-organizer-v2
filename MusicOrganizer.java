import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Muestra una lista de todos los archivos de la coleccion.
     */
    public void listAllFiles()
    {
        int position = 0;
        for (String filename : files) {
            System.out.println(position + ": " + filename);
            position ++;
        }
    }

    /**
     * Enumera los nombres de archivo que se corresponden con
     * la cadena de busqueda proporcionada.
     * @param searchString La cadena que hay que buscar.
     */
    public void listMatching(String searchString)
    {
        boolean coincidencia = false;
        for(String filename : files) {
            if(filename.contains(searchString)) {
                //Una coincidencia
                System.out.println(filename);
                coincidencia = true;
            }
        }
        if(coincidencia == false){
            System.out.println("No se han encontrado coincidencias");
        }
    }

    /**
     * Reproduce un poco de todas las canciones del artista deseado
     */
    public void singerAll(String singer)
    {
        boolean coincidencia = false;
        for(String filename : files) {
            if(filename.contains(singer)) {
                //Una coincidencia
                player.playSample(filename);
                coincidencia = true;
            }
        }
        if(coincidencia == false){
            System.out.println("No se han encontrado coincidencias");
        }
    }

    /**
     * Localizar el indice del primer archivo que se corresponde con
     * la cadena de busqueda indicada.
     * @param searchString la cadena que hay que buscar.
     * @return El indice de la primera aparicion, es decir -1 si
     * no se encuentra ninguna correspondencia.
     */
    public int findFirst(String searchString)
    {
        int index = 0;
        //Indicar que vamos a seguir buscando hasta encontrar una correspondencia.
        boolean searching = true;

        while(searching && index < files.size()){
            String filename = files.get(index);
            if(filename.contains(searchString)){
                //Una correspondecia. Podemos dejar de buscar.
                searching = false;
            }
            else {
                //Pasar al siguiente elemento.
                index ++;
            }
        }
        if(searching){
            index = -1;
        }
        return index;

    }
}
