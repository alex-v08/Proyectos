package com.DH.ClinicaOdontologica;

import com.DH.ClinicaOdontologica.dto.TurnoDTO;
import com.DH.ClinicaOdontologica.entity.Domicilio;
import com.DH.ClinicaOdontologica.entity.Odontologo;
import com.DH.ClinicaOdontologica.entity.Paciente;
import com.DH.ClinicaOdontologica.service.OdontologoService;
import com.DH.ClinicaOdontologica.service.PacienteService;
import com.DH.ClinicaOdontologica.service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionTurnosTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;
    //necesito un metodo para cargar los datos.
    private void cargarDatos(){
        Paciente pacienteAgregado=pacienteService.guardarPaciente(new Paciente("ani","loca","12356", LocalDate.of(2023,04,06), new Domicilio("Av, buen pastor",30,"Nueva Cordoba","Cordoba"),"rominamartin@dh.com"));
        Odontologo odontologoAgregado= odontologoService.guardarOdontologo(new Odontologo("MN100","Exequiel","Rodriguez"));
        TurnoDTO turnoDTO= new TurnoDTO();
        turnoDTO.setFecha(LocalDate.of(2023,05,20));
        turnoDTO.setOdontologoId(odontologoAgregado.getId());
        turnoDTO.setPacienteId(pacienteAgregado.getId());
        turnoService.guardarTurno(turnoDTO);
    }
    @Test
    public void ListarTurnosTest() throws Exception{

        cargarDatos();
        MvcResult respuesta= mockMvc.perform(MockMvcRequestBuilders.get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }

}
