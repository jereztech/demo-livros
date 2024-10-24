package br.com.mult_e.desafio;

import br.com.mult_e.desafio.model.Livro;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping()
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @GetMapping("/{id}/export")
    public ResponseEntity<byte[]> exportarLivro(@PathVariable Long id, @RequestParam(value = "format", defaultValue = "XML") ExportFormat format) throws Exception {
        Livro livro = livroService.findLivroById(id);
        String livroXml = XmlUtils.getXmlLivro(livro);
        byte[] outputBytes;
        String fileName;
        MediaType mediaType;

        switch (format) {
            case PDF:
                outputBytes = XmlUtils.getPdfFromXml(livroXml);
                fileName = "livro.pdf";
                mediaType = MediaType.APPLICATION_PDF;
                break;
            default:
                outputBytes = livroXml.getBytes("UTF-8");
                fileName = "livro.xml";
                mediaType = MediaType.APPLICATION_XML;
                break;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename(fileName).build());

        return ResponseEntity.ok()
                .headers(headers)
                .body(outputBytes);
    }

}
