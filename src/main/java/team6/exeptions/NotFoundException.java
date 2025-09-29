package team6.exeptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("L'elemento con id " + id + " non è stato trovato");
    }

    public NotFoundException(long id) {
        super("L'elemento con id " + id + " non è stato trovato");
    }
}
