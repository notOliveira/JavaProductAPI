package com.fatec.produto.services;

import com.fatec.produto.model.entities.Imagem;
import com.fatec.produto.model.repository.IImagemRepository;
import com.fatec.produto.model.repository.IProdutoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public interface IImagemService {

    public Optional<Imagem> salvar(MultipartFile imagem, Long id) throws IOException;
    public List<Imagem> getAll();
    public byte[] getImagem (String nomeArquivo);
    public byte[] getImagemById(Long id);
}
