package com.br.app.prcar.controller;

import com.br.app.prcar.data.ClienteEntity;
import com.br.app.prcar.data.ClienteRepository;
import com.br.app.prcar.service.ClienteService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")

public class IndexController {
    @Autowired
    private ClienteService clienteService;
    private ClienteRepository clienteRepository;
    
    public String index() {
        return "index";
    }
    
    @GetMapping("/novo")
    
    public String adicionarCliente(Model model){
        model.addAttribute("cliente", new ClienteEntity());
        return "/cadcliente";
    }
    
    @PostMapping("/salvar")
    public String SalvarPaciente(@RequestParam("data") String dataStr,
                             @Valid ClienteEntity cliente, BindingResult result) {
        //if(result.hasErrors()){
          //  return "/cadastro";
        //}
        
        //os.setEntrada(LocalDate.parse(txtEntrada.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataStr, formatter);
       clienteRepository.save(cliente);
       //attributes.addFlashAttribute("Mensagem", "Paciênte Cadastrado comm Sucesso");
       return "redirect:/novo";
}
    
    @GetMapping("/ultimos10")
    public String listarUltimos5Clientes(Model model) {
        List<ClienteEntity> ultimosClientes = clienteService.listarUltimos10Clientes();
        model.addAttribute("clientes", ultimosClientes);
        return "ListarClientes";
    }
}