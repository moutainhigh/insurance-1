import React, { PropTypes } from 'react';
import { Router, Route, IndexRoute, Link, hashHistory } from 'react-router';
import NotFound from 'components/common/NotFound';
import LoanList from 'components/loan/LoanList'
import RepaymentList from 'components/repayment/RepaymentList'
import Dealer from 'components/dealer/Dealer'
import AdminUserList from 'components/usermanage/AdminUserList'
const Routes = () =>
  <Router history={hashHistory}>
    <Route path="/" component={LoanList} />
    <Route path="/dealer" component={Dealer} />
    <Route path="/loan" component={LoanList}/>
    <Route path="/repayment" component={RepaymentList}/>
    <Route path="/adminUser" component={AdminUserList}/>
    <Route path="*" component={NotFound}/>
  </Router>;

Routes.propTypes = {
  history: PropTypes.any,
};

export default Routes;
