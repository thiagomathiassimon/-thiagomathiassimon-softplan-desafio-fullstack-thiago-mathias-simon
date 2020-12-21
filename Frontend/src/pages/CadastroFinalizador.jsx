import React from 'react';
import '../assets/css/Page.css';
import FormularioCadastro from '../components/FormularioCadastro';

class CadastroFinalizador extends React.Component {
  render() {
    return (
      <FormularioCadastro to='/loginfinalizador' toLogin='/loginfinalizador' />
    )
  }
}

export default CadastroFinalizador;