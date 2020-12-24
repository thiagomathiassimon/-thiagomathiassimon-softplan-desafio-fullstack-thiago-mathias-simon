import React from 'react';
import FormularioProcesso from '../components/FormularioProcesso';

class IncluirParecer extends React.Component {
  render() {
    return (
      <FormularioProcesso
        children={
          <>
            <div class="input-block">
              <label for="incluirProcesso-descricao">Parecer</label>
              <textarea type="text" id="incluirProcesso-descricao" />
            </div>
          </>
        }
        toPagina='/visualizarpendentes' btnTo="/visualizarpendentes" btnTitle="Incluir" />
    );
  }
}
export default IncluirParecer;