import React from 'react';
import ListarProcessos from '../components/ListarProcessos';
import { Link } from 'react-router-dom';

class VisualizarProcessosPendentes extends React.Component {
  render() {
    return (
      <ListarProcessos toPagina="/paginainicial"
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
    )
  }

}
export default VisualizarProcessosPendentes;