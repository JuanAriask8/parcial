package com.procesos.negocio.brainer;

import com.procesos.negocio.brainer.models.Usuario;
import com.procesos.negocio.brainer.repository.UsuarioRepository;
import com.procesos.negocio.brainer.services.UsuarioService;
import com.procesos.negocio.brainer.services.UsuarioServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


@SpringBootTest
public class UsuarioServiceMockTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    private UsuarioService usuarioService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Usuario usuario =  new Usuario();
        usuario.setId(1l);
        usuario.setNombre("Brainer");
        usuario.setApellidos("Gerena");
        usuario.setDocumento("1049030809");
        usuario.setCorreo("brainer@gmail");
        usuario.setPassword("Brainer17");


        @Test
        when(usuarioRepository.findAllByNombre("Brainer")).thenReturn(Optional.of(usuario));

        Usuario found = usuarioService.getUserById(1L);
        Assertions.assertThat(found.getName()).isEqualTo("Brainer");



}
