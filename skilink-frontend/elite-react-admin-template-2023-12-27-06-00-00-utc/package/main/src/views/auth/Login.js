import React from 'react';
import { Button, Label, FormGroup, Container, Row, Col, Card, CardBody, Input } from 'reactstrap';
import { Formik, Field, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import { Link, useNavigate } from 'react-router-dom';
import AuthLogo from "../../layouts/logo/AuthLogo";
import { ReactComponent as LeftBg } from '../../assets/images/bg/login-bgleft.svg';
import { ReactComponent as RightBg } from '../../assets/images/bg/login-bg-right.svg';

const Login = () => {
  const navigate = useNavigate();

  const initialValues = {
    email: '',
    password: '',
  };

  const validationSchema = Yup.object().shape({
    email: Yup.string().email('Email is invalid').required('Email is required'),
    password: Yup.string()
      .min(6, 'Password must be at least 6 characters')
      .required('Password is required'),
  });

  return (
    <div className="loginBox">
      <LeftBg className="position-absolute left bottom-0" style={{ width: '200px', height: '200px', fill: 'black' , filter: 'grayscale(100%) brightness(0%)'}} />
      <RightBg className="position-absolute end-0 top" style={{ width: '200px', height: '200px', fill: 'black' , filter: 'grayscale(100%) brightness(0%)'}} />
      <Container fluid className="h-100">
        <Row className="justify-content-center align-items-center h-100">
          <Col lg="6" md="8" sm="10" xs="12" className="loginContainer">
            <AuthLogo style={{ width: '100px', height: '100px' }} />
            <Card>
              <CardBody className="p-4 m-1">
                <h5 className="mb-3">Hello there! Welcome to Skilink!</h5>
                <small className="pb-4 d-block" style={{ fontSize: '18px' }}>
                Do not have an account? <Link to="/auth/registerformik" style={{ color: 'blue', fontSize: '16px' }}>Sign Up</Link>
                </small>
                <Formik
                  initialValues={initialValues}
                  validationSchema={validationSchema}
                  onSubmit={(fields) => {
                    alert(`SUCCESS!! :-)\n\n${JSON.stringify(fields, null, 4)}`);
                    navigate('/');
                  }}
                  render={({ errors, touched }) => (
                    <Form>
                      <FormGroup>
                        <Label htmlFor="email">Email</Label>
                        <Field
                          name="email"
                          type="text"
                          className={`form-control${
                            errors.email && touched.email ? ' is-invalid' : ''
                          }`}
                          style={{ fontSize: '16px' }}
                        />
                        <ErrorMessage name="email" component="div" className="invalid-feedback" />
                      </FormGroup>
                      <FormGroup>
                        <Label htmlFor="password">Password</Label>
                        <Field
                          name="password"
                          type="password"
                          className={`form-control${
                            errors.password && touched.password ? ' is-invalid' : ''
                          }`}
                          style={{ fontSize: '16px' }}
                        />
                        <ErrorMessage
                          name="password"
                          component="div"
                          className="invalid-feedback"
                        />
                      </FormGroup>
                      <FormGroup className="form-check d-flex" inline>
                        <Label check>
                          <Input type="checkbox" />
                          Remember me
                        </Label>
                        <Link className="ms-auto text-decoration-none" to="/auth/forgotPwd" style={{ color: 'blue', fontSize: '16px' }}>
                          <small>Forgot Pwd?</small>
                        </Link>
                      </FormGroup>
                      <FormGroup>
                        <Button type="submit" color="dark" className="me-2" style={{ fontSize: '16px' }}>
                          Login
                        </Button>
                      </FormGroup>
                    </Form>
                  )}
                />
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default Login;


// import React from 'react';
// import { Button, Label, FormGroup, Container, Row, Col, Card, CardBody, Input } from 'reactstrap';
// import { Formik, Field, Form, ErrorMessage } from 'formik';
// import * as Yup from 'yup';
// import { Link, useNavigate } from 'react-router-dom';
// import AuthLogo from "../../layouts/logo/AuthLogo";
// import { ReactComponent as LeftBg } from '../../assets/images/bg/login-bgleft.svg';
// import { ReactComponent as RightBg } from '../../assets/images/bg/login-bg-right.svg';

// const Login = () => {
//   const navigate = useNavigate();

//   const initialValues = {
//     email: '',
//     password: '',
//   };

//   const validationSchema = Yup.object().shape({
//     email: Yup.string().email('Email is invalid').required('Email is required'),
//     password: Yup.string()
//       .min(6, 'Password must be at least 6 characters')
//       .required('Password is required'),
//   });

//   return (
//     <div className="loginBox">
//       <Container fluid className="h-100">
//         <Row className="justify-content-center align-items-center h-100">
//           <Col lg="6" md="8" sm="10" xs="12">
//             <Card className="shadow bg-lightgrey"> {/* Added bg-lightgrey class */}
//               <CardBody className="p-4">
//                 <AuthLogo className="mb-4" />
//                 <h5 className="text-center mb-4">Hello there! Welcome to Skilink!</h5>
//                 <Formik
//                   initialValues={initialValues}
//                   validationSchema={validationSchema}
//                   onSubmit={(fields) => {
//                     // eslint-disable-next-line no-alert
//                     alert(`SUCCESS!! :-)\n\n${JSON.stringify(fields, null, 4)}`);
//                     navigate('/');
//                   }}
//                   render={({ errors, touched }) => (
//                     <Form>
//                       <FormGroup className="mb-3">
//                         <Label htmlFor="email">Email</Label>
//                         <Field
//                           name="email"
//                           type="text"
//                           className={`form-control ${
//                             errors.email && touched.email ? 'is-invalid' : ''
//                           }`}
//                         />
//                         <ErrorMessage name="email" component="div" className="invalid-feedback" />
//                       </FormGroup>
//                       <FormGroup className="mb-3">
//                         <Label htmlFor="password">Password</Label>
//                         <Field
//                           name="password"
//                           type="password"
//                           className={`form-control ${
//                             errors.password && touched.password ? 'is-invalid' : ''
//                           }`}
//                         />
//                         <ErrorMessage
//                           name="password"
//                           component="div"
//                           className="invalid-feedback"
//                         />
//                       </FormGroup>
//                       <FormGroup className="mb-3">
//                         <div className="form-check d-flex">
//                           <Label check className="flex-grow-1">
//                             <Input type="checkbox" />
//                             Remember me
//                           </Label>
//                           <Link to="/auth/forgotPwd" className="text-decoration-none" style={{ color: 'blue', fontSize: '16px' }}>
//                             <small>Forgot Password?</small>
//                           </Link>
//                         </div>
//                       </FormGroup>
//                       <FormGroup>
//                         <Button type="submit" color="dark" className="w-100">
//                           Login
//                         </Button>
//                       </FormGroup>
//                     </Form>
//                   )}
//                 />
//                 <div className="text-center mt-3">
//                   <small>Do not have an account? <Link to="/auth/registerformik" style={{ color: 'blue', fontSize: '16px' }}>Sign Up</Link></small>
//                 </div>
//               </CardBody>
//             </Card>
//           </Col>
//         </Row>
//       </Container>
//       <LeftBg className="position-absolute left bottom-0" style={{ fill: 'black' , filter: 'grayscale(100%) brightness(0%)'}} />
//       <RightBg className="position-absolute end-0 top" style={{ fill: 'black' , filter: 'grayscale(100%) brightness(0%)'}} />
//     </div>
//   );
// };

// export default Login;
