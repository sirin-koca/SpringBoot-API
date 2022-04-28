package oslomet.web.motorvogn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotorvognController {

    @Autowired
    private MotorvognRepository rep;

    @PostMapping ("/regMotorvogn")
    public void regMotorvogn(Motorvogn innMotorvogn){
        rep.regMotorvogn(innMotorvogn);
    }
}
