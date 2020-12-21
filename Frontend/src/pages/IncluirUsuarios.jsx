import React from 'react';
import { Link } from 'react-router-dom';
import FormularioCadastro from '../components/FormularioCadastro'

class IncluirUsuarios extends React.Component {
  render() {
    return (
      <FormularioCadastro to="/usuarios"
        children={
          <>
            <Link to='/usuarios'>
              <span>Não era o que queria? Retorne às opções!</span>
            </Link>
            <br />
            <br />
          </>
        }
      />
    );
  }
}
export default IncluirUsuarios;