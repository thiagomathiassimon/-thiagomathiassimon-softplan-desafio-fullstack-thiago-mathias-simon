import React from 'react';
import FormularioProcesso from '../components/FormularioProcesso';

class IncluirProcesso extends React.Component {
  render() {
    return (
      <FormularioProcesso toPagina='/' btnTo="/" btnTitle="Cadastrar" />
    );
  }
}
export default IncluirProcesso;