package com.uabc.edu.mx.citas_examen1.Controlador;

import com.uabc.edu.mx.citas_examen1.Modelo.Citas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorA {
private List<Citas> valores = new ArrayList<>();

    @RequestMapping(path="/agendar")
    public String lista (Model model){


        return "Agendar";
    }

    @RequestMapping(path="/consultar")
    public String consultar (Model model){

        model.addAttribute("lista", valores);
        return "Consultar";
    }

    @PostMapping("/add")
    public String add(String nombre,String asunto, String hora, String fecha, String medico){
        Citas c = new Citas();

        c.setNombre(nombre);
        c.setAsunto(asunto);
        c.setHora(hora);
        String[] fec = fecha.split("-");
        String f =fec[1]+"/"+fec[2]+"/"+fec[0];
        c.setFecha(f);
        c.setMedico(medico);
        valores.add(c);
        return "redirect:/agendar";
    }
}
