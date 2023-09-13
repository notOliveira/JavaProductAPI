package com.fatec.produto.services;

import com.fatec.produto.model.entities.Imagem;
import com.fatec.produto.model.entities.Produto;
import com.fatec.produto.model.repository.IImagemRepository;
import com.fatec.produto.model.repository.IProdutoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ImagemService implements IImagemService {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private IImagemRepository imagemRepository;
    @Autowired
    private IProdutoRepository produtoRepository;
    public Optional<Imagem> salvar(MultipartFile arquivo, long id) throws IOException {

        logger.info(">>>>>> servico salvar imagem - iniciado...");
        Optional<Produto> p = produtoRepository.findById(id);
        if (p.isPresent()) {
            logger.info(">>>>>> servico salvar imagem - produto encontrado");
            String nome = arquivo.getOriginalFilename();
            Path caminhoArquivo = Paths.get("imagens/" + nome);
            logger.info(">>>>>> servico salvar imagem - caminho arquivo => " + caminhoArquivo);
            Imagem imagem = new Imagem();
            imagem.setId(id); // associa o id do produto ao id da imagem
            imagem.setNome(arquivo.getOriginalFilename());
            imagem.setCaminho(caminhoArquivo.toString());
            imagem.setArquivo(arquivo.getBytes());
            logger.info(">>>>>> servico salvar imagem - arquivo getSize => " + arquivo.getSize());
            //Files.write(caminhoArquivo, arquivo.getBytes());
            return Optional.of(imagemRepository.save(imagem));
        } else {
            logger.info(">>>>>> servico salvar imagem - id nao encontrado");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Imagem> salvar(MultipartFile imagem, Long id) throws IOException {
        return Optional.empty();
    }

    public List<Imagem> getAll() {
        return imagemRepository.findAll();
    }
    public byte[] getImagem(String nomeArquivo) {
        Optional<Imagem> dbImagem = imagemRepository.findByNome(nomeArquivo);
        if (dbImagem.isPresent())
            return dbImagem.get().getArquivo();
        else
            return new byte[0];
    }
    public byte[] getImagemById(Long id) {
        Optional<Imagem> dbImagem = imagemRepository.findById(id);
        if (dbImagem.isPresent())
            return dbImagem.get().getArquivo();
        else
            return new byte[0];
    }
}