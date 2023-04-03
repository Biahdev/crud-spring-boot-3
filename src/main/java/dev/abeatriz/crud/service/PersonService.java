package dev.abeatriz.crud.service;

import dev.abeatriz.crud.mapper.DozerMapper;
import dev.abeatriz.crud.model.Person;
import dev.abeatriz.crud.repository.PersonRepository;
import dev.abeatriz.crud.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<PersonVO> findAll() {
        var personEntity = repository.findAll();
        // Transformando o tipo PersonEntity em PersonVO e retornando ele
        return DozerMapper.parseListObjects(personEntity, PersonVO.class);
    }

    public PersonVO findById( Long id ) {
        var personEntity = repository.findById(id);
        // Transformando o tipo PersonEntity em PersonVO e retornando ele
        return DozerMapper.parseObject(personEntity, PersonVO.class);
    }

    // Quero mostrar uma mensagem de a Pessoa X foi criada com sucesso
    public PersonVO create( PersonVO personVo ) {
        // Transformando o tipo PersonVO em PersonEntity
        var personEntity = DozerMapper.parseObject(personVo, Person.class);
        // Salvando no banco
        var personEntityRepository = repository.save(personEntity);
        //Transformando o tipo PersonEntity em PersonVO
        return DozerMapper.parseObject(personEntityRepository, PersonVO.class);

    }

    public PersonVO update( PersonVO personVo ) {
        var personEntity = repository.findById(personVo.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Não foi encontrado uma pessoa com esse id")
                );

        personEntity.setFirstName(personVo.getFirstName());
        personEntity.setLastName(personVo.getLastName());
        personEntity.setOccupation(personVo.getOccupation());
        personEntity.setPhone(personVo.getPhone());
        return DozerMapper.parseObject(personEntity, PersonVO.class);
    }

    // Quero mostrar uma mensagem de a Pessoa X foi deletada com sucesso
    public PersonVO delete( Long id ) {
        var personEntity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Não foi encontrado uma pessoa com esse id")
                );
        repository.delete(personEntity);
        return null;
    }
}
