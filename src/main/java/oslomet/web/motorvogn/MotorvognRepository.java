package oslomet.web.motorvogn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MotorvognRepository {

    @Autowired
    private JdbcTemplate db;

    public void regMotorvogn(Motorvogn innMotorvogn) {
        String sql =
                "INSERT INTO Motorvogn (personnr, navn, adresse, kjennetegn, merke, type) VALUES(?,?,?,?,?,?)";
        db.update(sql,
                innMotorvogn.getPersonnr(),
                innMotorvogn.getNavn(),
                innMotorvogn.getAdresse(),
                innMotorvogn.getKjennetegn(),
                innMotorvogn.getMerke(),
                innMotorvogn.getType()
        );
    }

    public List<Motorvogn> hentAlleMotorvogn() {
        String sql = "SELECT * FROM Motorvogn";
        List<Motorvogn> alleMotorvogn = db.query(sql,
                new BeanPropertyRowMapper(Motorvogn.class));
        return alleMotorvogn;
    }

    public void slettAlleMotorvogn() {
        String sql = "DELETE FROM Motorvogn";
        db.update(sql);

    }
}
