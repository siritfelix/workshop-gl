package ar.com.globallogic.workshop.domain;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Domain implements Comparable<Domain> {
    private Integer id;
    private String mensaje;
    private String field;

    @Override
    public int compareTo(Domain o) {
        return id.compareTo(o.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return this.id.equals(((Domain) obj).getId()) && this.mensaje.equals(((Domain) obj).getMensaje());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mensaje);
    }
}
