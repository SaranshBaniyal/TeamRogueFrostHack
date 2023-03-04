import { Parallax } from "react-parallax";
import img1 from "../image/b.jpg";
const ImageOne = () => (
  <Parallax
    className="image"
    blur={0}
    bgImage={img1}
    strength={800}
    bgImageStyle={{ minHeight: "100vh" }}
  >
    <div className="content">
      <span className="img-txt">Emosense</span>
    </div>
  </Parallax>
);

export default ImageOne;
