import React from 'react';
import '../assets/css/Page.css';
import FormularioCadastro from '../components/FormularioCadastro';
import PossuiCadastro from '../components/PossuiCadastro';
import UsuarioAPI from '../services/UsuarioAPI';

class CadastroAdministrador extends React.Component {
  constructor(props) {
    super(props);

    this.state = { usuarios: [] };
    this.excluirUsuario = this.excluirUsuario.bind(this);
  }

  componentDidMount() {
    this.carregarUsuarios();
  }

  componentDidUpdate(prevState) {
    if (this.state.usuarioEmEdicao === prevState.usuarioEmEdicao) {
      return;
    }

    console.log("this.state.usuarioEmEdicao no Update", this.state.usuarioEmEdicao);
  }

  async carregarUsuarios() {
    const usuarios = await UsuarioAPI.buscarUsuarios();
    this.setState({ usuarios: usuarios });
  }

  editarUsuario = (usuarios) => {
    this.setState({ usuarioEmEdicao: usuarios });
  }

  excluirUsuario(usuarios) {

    UsuarioAPI.excluirUsuario(usuarios.id).then(() => this.carregarUsuarios());
  }

  salvarUsuario = usuario => {
    if (usuario.id) {
      UsuarioAPI.atualizarUsuario(usuario).then(() => {
        this.carregarUsuarios();
        this.setState({ usuarioEmEdicao: null });
      });
      return;
    }
    console.log("Passando no else do salvarUsuario")
    UsuarioAPI.inserirUsuario(usuario).then(() => {
      this.carregarUsuarios();
      this.setState({ usuarioEmEdicao: null })
    });
  }

  render() {
    return (
      <FormularioCadastro usuario={this.state.usuarioEmEdicao} salvar={this.salvarUsuario} to='/loginadministrador'
        children={
          <PossuiCadastro toLogin='/loginadministrador' />
        }
      />
    )
  }
}

export default CadastroAdministrador;