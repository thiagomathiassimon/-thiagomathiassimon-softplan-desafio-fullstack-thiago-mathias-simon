import axios from 'axios';

const BASE_URL = 'http://localhost:8080/RESTDesafioSoftplanThiagoMathiasSimon/api/usuario'

class UsuarioService {

  buscarUsuarios() {
    return axios.get(BASE_URL)
      .then(response => response.data)
      .catch(error => {
        throw error;
      });
  }

  inserirUsuario(usuario) {
    return axios.post(BASE_URL, usuario)
      .then(usuario => usuario)
      .catch(error => {
        throw error;
      })
  }

  atualizarUsuario(usuario) {
    return axios.put(`${BASE_URL}/${usuario.id_usuario}`, usuario)
      .catch(error => {
        throw error;
      })
  }

  excluirUsuario(id) {
    return axios.delete(`${BASE_URL}/${id}`)
      .catch(error => {
        throw error;
      });
  }
}


export default new UsuarioService();
