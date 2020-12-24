import axios from 'axios';

const BASE_URL = 'http://localhost:8080/RESTDesafioSoftplanThiagoMathiasSimon/api/processo'

class ProcessoService {

  buscarProcessos() {
    return axios.get(BASE_URL)
      .then(response => response.data)
      .catch(error => {
        throw error;
      });
  }

  inserirProcesso(processo) {
    return axios.post(BASE_URL, processo)
      .then(processo => processo)
      .catch(error => {
        throw error;
      })
  }

  atualizarProcesso(processo) {
    return axios.put(`${BASE_URL}/${processo.id_processo}`, processo)
      .then(() => {
        console.log(processo)
        console.log(processo.id_processo)
      })
      .catch(error => {
        throw error;
      })
  }

  excluirProcesso(id) {
    return axios.delete(`${BASE_URL}/${id}`)
      .catch(error => {
        throw error;
      });
  }
}


export default new ProcessoService();
