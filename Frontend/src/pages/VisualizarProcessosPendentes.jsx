import React from 'react';
import ListarProcessosPendentes from '../components/ListarProcessosPendentes';
import { Link } from 'react-router-dom';
import FormularioEdicaoPendentes from '../components/FormularioEdicaoPendentes';
import ProcessoAPI from '../services/ProcessoAPI';

class VisualizarProcessosPendentes extends React.Component {
  constructor(props) {
    super(props);
    this.state = { processos: [] };
  }

  componentDidMount() {
    this.carregarProcessos();
  }

  async carregarProcessos() {
    const processos = await ProcessoAPI.buscarProcessos();
    this.setState({ processos: processos });
  }

  editarProcessso = (processos) => {
    this.setState({ processoEmEdicao: processos });
  }

  excluirProcesso(processos) {
    ProcessoAPI.excluirProcesso(processos.id_processo).then(() => this.carregarProcessos());
  }

  salvarProcesso = processos => {
    if (processos.id_processo) {
      ProcessoAPI.atualizarProcesso(processos).then(() => {
        this.carregarProcessos();
        this.setState({ processoEmEdicao: null });
      });
      return;
    }

    ProcessoAPI.inserirProcesso(processos).then(() => {
      this.carregarProcessos();
      this.setState({ processoEmEdicao: null })
    });
  }

  render() {
    return (
      <>
        <ListarProcessosPendentes editar={this.editarProcessso} excluir={this.excluirProcesso} processo={this.state.processos} toPagina="/paginainicial"
          children={
            <>
              <Link to='/incluirparecer'>
                <button type="submit" class="btn-editar">
                  Adicionar Parecer
             </button>
              </Link>
            </>
          }
        />
        <FormularioEdicaoPendentes processo={this.state.processoEmEdicao} salvar={this.salvarProcesso} />
      </>
    )
  }
}

export default VisualizarProcessosPendentes;