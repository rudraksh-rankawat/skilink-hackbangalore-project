// import { useSelector } from 'react-redux';
// import { Link } from 'react-router-dom';
// import React from 'react';
// import { ReactComponent as LogoDarkIcon } from '../../assets/images/logos/elite-dark-icon.svg';
// import LogoDarkText from '../../assets/images/logos/logo-text.png';
// import { ReactComponent as LogoWhiteIcon } from '../../assets/images/logos/elite-white-icon.svg';
// import LogoWhiteText from '../../assets/images/logos/logo-light-text.png';

// const HorizontalLogo = () => {
//   const isDarkMode = useSelector((state) => state.customizer.isDark);
//   const activetopbarBg = useSelector((state) => state.customizer.topbarBg);
//   return (
//     <Link to="/" className="d-flex align-items-center gap-2">
//       {isDarkMode || activetopbarBg !== 'white' ? (
//         <>
//           <LogoWhiteIcon />
//           <img src={LogoWhiteText} className="d-none d-lg-block" alt='logo-text' />
//         </>
//       ) : (
//         <>
//           <LogoDarkIcon />
//           <img src={LogoDarkText} className="d-none d-lg-block" alt='logo-text' />
//         </>
//       )}
//     </Link>
//   );
// };

// export default HorizontalLogo;


import React from 'react';
import { useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

const HorizontalLogo = () => {
  const isDarkMode = useSelector((state) => state.customizer.isDark);
  const activetopbarBg = useSelector((state) => state.customizer.topbarBg);
  
  const logoStyle = {
    fontSize: '24px', // Adjust font size as needed
    fontWeight: 'bold', // Adjust font weight as needed
    color: isDarkMode || activetopbarBg !== 'white' ? '#ffffff' : '#000000', // Change color based on mode
  };

  return (
    <Link to="/auth" className="d-flex align-items-center gap-2" style={logoStyle}>
      Skilink.
    </Link>
  );
};

export default HorizontalLogo;
