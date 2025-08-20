package br.com.dio.lab_padroe_spring.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.lab_padroe_spring.model.Cliente;
import br.com.dio.lab_padroe_spring.model.Endereco;
import br.com.dio.lab_padroe_spring.repository.ClienteRepository;
import br.com.dio.lab_padroe_spring.repository.EnderecoRepository;
import br.com.dio.lab_padroe_spring.service.ClienteService;
import br.com.dio.lab_padroe_spring.service.ViaCepService;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar Todos os Clientes
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar Cliente por ID
        if (repository.findById(id).isEmpty() || id == null) {
            throw new RuntimeException("Cliente não encontrado com ID: " + id);
        } else {
            Optional<Cliente> cliente = repository.findById(id);
            return cliente.get();
        }

    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar Cliente por ID, caso exista:
        Optional<Cliente> clienteExiste = repository.findById(id);
        if (clienteExiste.isPresent()) {
            // Verificar se o endereço do Cliente já existe ( pelo CEP )
            salvarClienteComCep(cliente);
            // Caso não exista, integrar com o ViaCep e persistir o retorno
            // Alterar Cliente, vinculando o endereço ( novo ou existente)
        }

    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);

    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        // Verificar se o Endereço do Cliente já existe ( pelo CEP )
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        // Inserir Cliente, vinculando o endereço( Novo ou existente )0
        cliente.setEndereco(endereco);
        repository.save(cliente);
    }

}
