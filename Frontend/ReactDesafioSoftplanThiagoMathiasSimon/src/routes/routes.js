import React from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import Processo from '../pages/Processo';
import IncluirProcesso from '../pages/IncluirProcesso';
import VizualizarProcessos from '../pages/VisualizarProcessos';
import Usuarios from '../pages/Usuarios'
import IncluirUsuarios from '../pages/IncluirUsuarios';
import VizualizarUsuarios from '../pages/VisualizarUsuarios';
import LoginAdministrador from '../pages/LoginAdministrador';
import LoginTriador from '../pages/LoginTriador';
import LoginFinalizador from '../pages/LoginFinalizador';
import CadastroAdministrador from '../pages/CadastroAdministrador';
import CadastroTriador from '../pages/CadastroTriador';
import CadastroFinalizador from '../pages/CadastroFinalizador';
import PaginaInicial from '../pages/PaginaInicial';
import IncluirParecer from '../pages/IncluirParecer';
import VisualizarPendentes from '../pages/VisualizarProcessosPendentes'
import NotFound from './NotFound'

const PrivateRoute = props => {
  const isLogged = !!localStorage.getItem('token')
  return isLogged ? <Route {...props} /> : <Redirect to="/paginainicial" />
}

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route path='/paginainicial' component={PaginaInicial} />
      <Route path='/loginadministrador' component={LoginAdministrador} />
      <Route path='/logintriador' component={LoginTriador} />
      <Route path='/loginfinalizador' component={LoginFinalizador} />
      <Route path='/cadastroadministrador' component={CadastroAdministrador} />
      <Route path='/cadastrotriador' component={CadastroTriador} />
      <Route path='/cadastrofinalizador' component={CadastroFinalizador} />
      <PrivateRoute exact path='/' component={Processo} />
      <PrivateRoute path='/incluirprocesso' component={IncluirProcesso} />
      <PrivateRoute path='/visualizarprocessos' component={VizualizarProcessos} />
      <PrivateRoute path='/usuarios' component={Usuarios} />
      <PrivateRoute path='/incluirusuarios' component={IncluirUsuarios} />
      <PrivateRoute path='/visualizarusuarios' component={VizualizarUsuarios} />
      <PrivateRoute path='/incluirparecer' component={IncluirParecer} />
      <PrivateRoute path='/visualizarpendentes' component={VisualizarPendentes} />
      <Route component={NotFound} />
    </Switch>
  </BrowserRouter>
)

export default Routes;