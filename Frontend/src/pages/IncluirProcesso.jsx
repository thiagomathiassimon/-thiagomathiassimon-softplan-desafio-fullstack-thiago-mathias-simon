import React from 'react';
import FormularioProcesso from '../components/FormularioProcesso';
import ProcessoAPI from '../services/ProcessoAPI';
import { Link } from 'react-router-dom'

class IncluirProcesso extends React.Component {
  constructor(props) {
    super(props);

    this.state = { processos: [] };
    this.excluirProcesso = this.excluirProcesso.bind(this);
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
    this.setState({ processoEmEdicao: processos });
  }

  excluirProcesso(processos) {
    ProcessoAPI.excluirProcesso(processos.id).then(() => this.carregarProcessos());
  }

  salvarProcesso = processo => {
    if (processo.id) {
      ProcessoAPI.atualizarProcesso(processo).then(() => {
        this.carregarProcessos();
        this.setState({ processoEmEdicao: null });
      });
      return;
    }
    console.log("Passando no else do salvarProcesso")
    ProcessoAPI.inserirProcesso(processo).then(() => {
      this.carregarProcessos();
      this.setState({ processoEmEdicao: null })
    });
  }

  render() {
    return (
      <FormularioProcesso processo={this.state.processoEmEdicao} salvar={this.salvarProcesso} toPagina='/' btnTo="/" btnTitle="Cadastrar"
      />
    );
  }
}

export default IncluirProcesso;