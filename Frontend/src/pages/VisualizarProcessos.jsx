import React from 'react';
import ListarProcessos from '../components/ListarProcessos';

class VisualizarProcessos extends React.Component {
  render() {
    return (
      <ListarProcessos
        children={
          <>
            <button type="submit" class="btn-editar">
              Editar
             </button>
            <label> </label>
            <button type="submit" class="btn-excluir">
              Excluir
             </button>
          </>
        }
        toPagina="/usuarios"
      />
    );
  }
}
export default VisualizarProcessos;