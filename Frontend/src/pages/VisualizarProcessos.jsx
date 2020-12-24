import React from 'react';
import ListarProcessos from '../components/ListarProcessos';
import FormularioEdicao from '../components/FormularioEdicao';
import ProcessoAPI from '../services/ProcessoAPI';


class VisualizarProcessos extends React.Component {

  constructor(props) {
    super(props);

    this.state = { processos: [] };
    // this.excluirProcesso = this.excluirProcesso.bind(this);
  }

  componentDidMount() {
    this.carregarProcessos();
  }

  componentDidUpdate(prevProps, prevState) {
    if (this.state.processoEmEdicao === prevState.processoEmEdicao) {
      return;
    }

    console.log("this.state.processoEmEdicao no Update", this.state.processoEmEdicao);
  }

  async carregarProcessos() {
    const processos = await ProcessoAPI.buscarProcessos();
    this.setState({ processos: processos });
  }

  editarProcesso = (processos) => {
    console.log("processoEmEdição: ", processos)
    console.log(processos)
    this.setState({ processoEmEdicao: processos });
  }

  excluirProcesso(processos) {
    console.log("Passando na função excluirProcesso")
    console.log(processos)
    console.log(processos.id_processo)
    ProcessoAPI.excluirProcesso(processos.id_processo).then(() => this.carregarProcessos());
  }

  salvarProcesso = processos => {
    console.log("chegando no salvar processo")
    console.log("1", processos.id)
    console.log("2", processos)
    console.log("3", processos.id_processo)
    if (processos.id_processo) {
      console.log("passando pelo if (processos.id)")
      ProcessoAPI.atualizarProcesso(processos).then(() => {
        this.carregarProcessos();
        this.setState({ processoEmEdicao: null });
      });
      console.log(this.processoEmEdicao)
      return;
    }

    ProcessoAPI.inserirProcesso(processos).then(() => {
      this.carregarProcessos();
      this.setState({ processoEmEdicao: null })
    });
  }


  render() {

    //console.log(this.state.processos)

    return (
      <>
        <ListarProcessos editar={this.editarProcesso} excluir={this.excluirProcesso} processo={this.state.processos}
          bntTo='/'
          toPagina="/"
        />
        <FormularioEdicao processo={this.state.processoEmEdicao} salvar={this.salvarProcesso} />

      </>
    );
  }
}
export default VisualizarProcessos;