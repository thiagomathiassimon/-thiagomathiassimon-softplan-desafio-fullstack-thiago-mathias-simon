import React from 'react';
import ListarUsuarios from '../components/ListarUsuarios';
import FormularioEdicaoUsuario from '../components/FormularioEdicaoUsuario'
import UsuarioAPI from '../services/UsuarioAPI';

class VisualizarUsuarios extends React.Component {
  constructor(props) {
    super(props);
    this.state = { usuarios: [] };
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
    console.log("usuarioEmEdição: ", usuarios)
    console.log(usuarios)
    this.setState({ usuarioEmEdicao: usuarios });
  }

  excluirUsuario(usuarios) {
    console.log("Passando na função excluirUsuario")
    console.log(usuarios)
    console.log(usuarios.id_usuario)
    UsuarioAPI.excluirUsuario(usuarios.id_usuario).then(() => this.carregarUsuarios());
  }

  salvarUsuario = usuarios => {
    console.log("chegando no salvar usuario")
    console.log("1", usuarios.id)
    console.log("2", usuarios)
    console.log("3", usuarios.id_usuario)
    if (usuarios.id_usuario) {
      console.log("passando pelo if (usuarios.id)")
      UsuarioAPI.atualizarUsuario(usuarios).then(() => {
        this.carregarUsuarios();
        this.setState({ usuarioEmEdicao: null });
      });
      console.log(this.usuarioEmEdicao)
      return;
    }

    UsuarioAPI.inserirUsuario(usuarios).then(() => {
      this.carregarUsuarios();
      this.setState({ usuarioEmEdicao: null })
    });
  }

  render() {
    return (
      <>
        <ListarUsuarios editar={this.editarUsuario} excluir={this.excluirUsuario} usuario={this.state.usuarios} />
        <FormularioEdicaoUsuario usuario={this.state.usuarioEmEdicao} salvar={this.salvarUsuario} />
      </>
    )
  }
}

export default VisualizarUsuarios;