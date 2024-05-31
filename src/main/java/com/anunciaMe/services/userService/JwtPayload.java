package com.anunciaMe.services.userService;

public class JwtPayload {
        private String userId;
        private Long creationDate;
        private Long expirationDate;

        public JwtPayload(String userId, Long creationDate, Long expirationDate) {
            this.userId = userId;
            this.creationDate = creationDate;
            this.expirationDate = expirationDate;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }


        public Long getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Long creationDate) {
            this.creationDate = creationDate;
        }

        public Long getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(Long expirationDate) {
            this.expirationDate = expirationDate;
        }

        @Override
        public String toString() {
            return "Payload{" +
                    "userId='" + userId + '\'' +
                    ", creationDate=" + creationDate +
                    ", expirationDate=" + expirationDate +
                    '}';
        }

}
