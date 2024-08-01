package sistemadeingressos;

import java.util.HashMap;

public class SistemaIngresso {
    private HashMap<String,Show> shows;


    public SistemaIngresso() {
        this.shows = new HashMap<String, Show>();
    }

    public HashMap<String, Show> getShows() {
        return shows;
    }
}
