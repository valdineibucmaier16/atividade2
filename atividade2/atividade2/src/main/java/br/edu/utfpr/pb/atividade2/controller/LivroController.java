package br.edu.utfpr.pb.atividade2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.pb.atividade2.model.Livro;
import br.edu.utfpr.pb.atividade2.service.AutorService;
import br.edu.utfpr.pb.atividade2.service.CidadeService;
import br.edu.utfpr.pb.atividade2.service.EditoraService;
import br.edu.utfpr.pb.atividade2.service.GeneroService;
import br.edu.utfpr.pb.atividade2.service.LivroService;



@Controller
@RequestMapping("livro")
public class LivroController {

	@Autowired
	private EditoraService editoraService;
	@Autowired
	private GeneroService generoService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private LivroService livroService;
	
	
	
	
	@GetMapping
	public String list( Model model ) {
		model.addAttribute("livros", livroService.findAll());
		return "livro/list";
	}
	
	@GetMapping({"new", "novo"})
	public String form( Model model) {
		
		model.addAttribute("livro", new Livro());
		
		carregarCombos(model);
		
		return "livro/form";
	}
	
	private void carregarCombos(Model model) {
		model.addAttribute("cidades", cidadeService.findAll() );
		
		model.addAttribute("autores", autorService.findAll() );
		
		model.addAttribute("editoras", editoraService.findAll() );
		
		model.addAttribute("generos", generoService.findAll() );
		
		
		
	}
	
	@PostMapping
	public String save(@Valid Livro livro,
					   BindingResult result,
					   Model model,
					   RedirectAttributes attributes) {
		if (result.hasErrors()) {
			model.addAttribute("livro", livro);
			carregarCombos(model);
			return "livro/form";
		}
		livroService.save(livro);
		attributes.addFlashAttribute("sucesso", 
				"Registro salvo com sucesso!");
		return "redirect:/livro";
	}
	
	@GetMapping("{id}")
	public String form(@PathVariable Long id, Model model) {
		model.addAttribute("livro", livroService.findOne(id));
		carregarCombos(model);
		return "livro/form";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id, 
			 			 Model model,
			 			 RedirectAttributes attributes) {
		try {
			livroService.delete(id);
			attributes.addFlashAttribute("sucesso", 
					"Registro removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("erro", 
					"Falha ao remover registro");
		}
		return "redirect:/livro";
	}
}
