import { Row, Col } from 'reactstrap';
import RecentComments from '../../components/dashboard/minimalDashboard/RecentComments';

const Minimal = () => {
  return (
    <>
      <Row>
        <Col lg="12">
          <RecentComments />
        </Col>
      </Row>
      
    </>
  );
};

export default Minimal;
