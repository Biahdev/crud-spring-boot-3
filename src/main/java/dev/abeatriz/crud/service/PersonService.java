package dev.abeatriz.crud.service;

import dev.abeatriz.crud.mapper.DozerMapper;
import dev.abeatriz.crud.repository.PersonRepository;
import dev.abeatriz.crud.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<PersonVO> findAll(){
        var entity = repository.findAll();
        return DozerMapper.parseListObjects(entity, PersonVO.class);
    }

    public PersonVO findById(Long id){
        var entity =  repository.findById(id);
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    // Quero mostrar uma mensagem de a Pessoa X foi criada com sucesso
    public PersonVO create(PersonVO person){
        var entity = DozerMapper.parseObject(person, PersonVO.class);
        var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {}

    // Quero mostrar uma mensagem de a Pessoa X foi deletada com sucesso
    public PersonVO delete(Long id) {
        var entity = repository.findById(id);
        var vo =  DozerMapper.parseObject(repository.delete(entity), PersonVO.class);
        return vo;
    }




}
